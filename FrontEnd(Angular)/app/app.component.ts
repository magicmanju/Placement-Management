import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CollegeService } from './college.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'college-module';

  CollegeDetails=null as any;
  collegeToUpdate={
    id:"",
    name:"",
    location:"",
    admin:""
  }

  constructor(private collegeService: CollegeService){
    this.getCollegeDetails();
  }

  register(registerForm:NgForm){
    this.collegeService.registerCollege(registerForm.value).subscribe(
      (resp)=>{
        console.log(resp);
        registerForm.reset();
        this.getCollegeDetails();
      },
      (err)=>{
        console.log(err);
      }
    );
  }

  getCollegeDetails(){
    this.collegeService.getColleges().subscribe(
      (resp)=>{
        console.log(resp);
        this.CollegeDetails=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }

  deleteCollege(college: any) {
    console.log("Deleting college with id:", college.id);
    this.collegeService.deleteCollege(college.id).subscribe(
      (resp) => {
        alert("You confirmed your action.");
        location.href = location.href;
        console.log("Delete response:", resp);
      },
      (err) => {
        alert("You confirmed your action.");
        console.error("Error deleting college:", err);
      }
    );
  }
  

  edit(college:any){
    this.collegeToUpdate=college
  }

  updateCollege(){
    this.collegeService.updateColleges(this.collegeToUpdate).subscribe(
      (resp)=>{
        console.log(resp);
      },
      (err)=>{
        console.log(err);
      }
    );
  }
}
