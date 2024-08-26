import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CollegeService {

  API='http://localhost:8087';
  constructor(private http: HttpClient) { }


  public registerCollege(CollegeData:any){
    return this.http.post(this.API+'/registercollege',CollegeData)
  }

  public getColleges(){
    return this.http.get(this.API+'/getcollege');
  }

  public deleteCollege(id:any){
     return this.http.delete(this.API+'/deletecollege?id=' +id);
  }

  public updateColleges(college:any){
    return this.http.put(this.API+'/updatecollege',college);
  }
}
