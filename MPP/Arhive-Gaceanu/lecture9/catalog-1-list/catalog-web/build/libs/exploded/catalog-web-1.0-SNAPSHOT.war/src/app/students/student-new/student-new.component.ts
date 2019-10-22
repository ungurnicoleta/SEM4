import {Component, OnInit} from '@angular/core';
import {StudentService} from "../shared/student.service";
import {Location} from "@angular/common"

@Component({
  selector: 'app-student-new',
  templateUrl: './student-new.component.html',
  styleUrls: ['./student-new.component.css']
})
export class StudentNewComponent implements OnInit {

  constructor(private studentService: StudentService,
              private location: Location) {
  }

  ngOnInit() {
  }

  save(serialNumber, name, groupNumber) {
    console.log("save button pressed", serialNumber, name, groupNumber);

    this.studentService.save(serialNumber, name, groupNumber)
      .subscribe(_ => {
          console.debug("student saved");
          this.location.back();
        },
        err => console.error("error saving student", err));
  }

}
