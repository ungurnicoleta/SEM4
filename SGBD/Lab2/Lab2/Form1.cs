using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Configuration;

namespace Lab2
{
    public partial class Form1 : Form
    {
        SqlConnection conexiune;
        DataSet ds;
        SqlDataAdapter da;

        //Binding sources
        BindingSource bsC;
        BindingSource bsP;
        List<TextBox> textBoxList;
        List<Label> labelList;
        int idx = 0;

        public Form1()
        {
            InitializeComponent();
        }

        public void fillDataSet()
        {
            conexiune.Open();

            string selectcmd = ConfigurationManager.AppSettings["ParentSelectCmd"];
            da.SelectCommand = new SqlCommand(selectcmd, conexiune);
            da.Fill(ds, "ParentTable");

            selectcmd = ConfigurationManager.AppSettings["ChildSelectCmd"];
            da.SelectCommand = new SqlCommand(selectcmd, conexiune);
            da.Fill(ds, "ChildTable");
            conexiune.Close();
        }

        public void getData()
        {
            //setare bidingSource
            string parentId = ConfigurationManager.AppSettings["idParent"];
            string childId = ConfigurationManager.AppSettings["idChild"];

            DataRelation relation = new DataRelation("Parent_Child_FK",
                ds.Tables["ParentTable"].Columns[parentId],
                ds.Tables["ChildTable"].Columns[childId],false);
            ds.Relations.Add(relation);

            bsP.DataSource = ds;
            bsP.DataMember = "ParentTable";

            bsC.DataSource = bsP;
            bsC.DataMember = "Parent_Child_FK";
        }

        public void populateDataGridViews()
        {
            GridViewParent.DataSource = bsP;
            GridViewChild.DataSource = bsC;
            getData();
            GridViewChild.AutoResizeColumns();
            GridViewParent.AutoGenerateColumns = true;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            ConnectionStringSettings conSet = ConfigurationManager.ConnectionStrings["cn"];
            string connectionString = conSet.ConnectionString;
            conexiune = new SqlConnection(connectionString);

            bsP = new BindingSource();
            bsC = new BindingSource();
            da = new SqlDataAdapter();
            ds = new DataSet();

            fillDataSet();
            populateDataGridViews();
            setUpTextBoxAndLabels();
        }


        private void setUpTextBoxAndLabels()
        {
            idx = 0;
            textBoxList = new List<TextBox>();
            labelList = new List<Label>();

            foreach (Control item in flowLayoutPanel1.Controls.OfType<TextBox>())
            {
                flowLayoutPanel1.Controls.Remove(item);
            }
            foreach (Control item in flowLayoutPanel1.Controls.OfType<Label>())
            {
                flowLayoutPanel1.Controls.Remove(item);
            }
            int columnNr = ds.Tables["ChildTable"].Columns.Count;

            for (int i = 2; i < columnNr; i++)
            {
                Label label = new Label();
                label.Text = ds.Tables["ChildTable"].Columns[i].ColumnName;


                Point textP = new Point(idx * 120, 44);
                Point lableP = new Point(idx * 120, 30);
                label.Location = lableP;
                label.AutoSize = true;

                TextBox textBox = new TextBox();
                textBox.Location = textP;
                textBoxList.Add(textBox);
                labelList.Add(label);
                idx++;

                flowLayoutPanel1.Controls.Add(label);
                flowLayoutPanel1.Controls.Add(textBox);
            }

        }

        private void AddButton_Click(object sender, EventArgs e)
        {
            //adaugare
            conexiune.Open();
            string value;
            int i = 0;
            int selectedRowindex = GridViewParent.SelectedCells[0].RowIndex;
            string foreingID = GridViewParent.Rows[selectedRowindex].Cells[Convert.ToInt32(ConfigurationManager.AppSettings["PKColumn"])].Value.ToString();
            string insertCmd = ConfigurationManager.AppSettings["ChildInsertCmd"];
            da.InsertCommand = new SqlCommand(insertCmd, conexiune);
            int nrColumns = ds.Tables["ChildTable"].Columns.Count;
            value = "@value" + (i + 1).ToString();
            da.InsertCommand.Parameters.AddWithValue(value, foreingID);
            for (i = 1; i < nrColumns-1; i++)
            {
                value = "@value" + (i+1).ToString();
                da.InsertCommand.Parameters.AddWithValue(value, textBoxList[i-1].Text);
            }
            da.InsertCommand.ExecuteNonQuery();
            ds.Tables["ChildTable"].Clear();
            string selectcmd = ConfigurationManager.AppSettings["ChildSelectCmd"];
            da.SelectCommand = new SqlCommand(selectcmd, conexiune);
            da.Fill(ds, "ChildTable");
            conexiune.Close();
        }

        private void UpdateButton_Click(object sender, EventArgs e)
        {
            //actualizare
            if (GridViewChild.SelectedCells.Count > 0)
            {
                conexiune.Open();
                string updateCmd = ConfigurationManager.AppSettings["ChildUpdateCmd"];
                da.UpdateCommand = new SqlCommand(updateCmd, conexiune);

                String id_hall = GridViewChild.CurrentRow.Cells[0].Value.ToString();
                int index = ds.Tables["ChildTable"].Columns.Count;
                int i = 0;
                string value;
                for (i = 0; i < index - 2; i++)
                {
                    value = "@value" + (i + 1).ToString();

                    da.UpdateCommand.Parameters.AddWithValue(value, textBoxList[i].Text);
                }
                value = "@value" + (i + 1).ToString();
                da.UpdateCommand.Parameters.AddWithValue(value, id_hall);
                da.UpdateCommand.ExecuteNonQuery();
                ds.Tables["ChildTable"].Clear();
                string selectcmd = ConfigurationManager.AppSettings["ChildSelectCmd"];
                da.SelectCommand = new SqlCommand(selectcmd, conexiune);
                da.Fill(ds, "ChildTable");
                conexiune.Close();
            }
        }

        private void RemoveButton_Click(object sender, EventArgs e)
        {
            if (GridViewChild.SelectedCells.Count > 0)
            {
                conexiune.Open();
                int selectedrowindex = GridViewChild.SelectedCells[0].RowIndex;

                DataGridViewRow selectedRow = GridViewChild.Rows[selectedrowindex];

                string toDeletedId = Convert.ToString(selectedRow.Cells[0].Value);

                string deleteCmd = ConfigurationManager.AppSettings["ChildDeleteCmd"];
                da.DeleteCommand = new SqlCommand(deleteCmd, conexiune);

                da.DeleteCommand.Parameters.AddWithValue("value", toDeletedId);

                da.DeleteCommand.ExecuteNonQuery();
                ds.Tables["ChildTable"].Clear();
                string selectcmd = ConfigurationManager.AppSettings["ChildSelectCmd"];
                da.SelectCommand = new SqlCommand(selectcmd, conexiune);
                da.Fill(ds, "ChildTable");

                conexiune.Close();
            }
            else
                MessageBox.Show("Selectati o linie");
        }

    }

}

