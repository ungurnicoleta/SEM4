import {Component} from "@angular/core";
import {Router} from "@angular/router"

@Component({
  moduleId: module.id,
  selector: 'ubb-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css'],
})
export class StudentsComponent {

  constructor(private router: Router) {

  }

  addStudent() {
    console.log("addStudent button pressed");
    this.router.navigate(["/student-new"]);
  }

}
