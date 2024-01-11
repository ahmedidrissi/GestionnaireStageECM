import { Injectable } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root',
})
export class StudentsService {
  private baseUrl = AppComponent.baseUrl + '/students';
  private httpOptions = {
    headers: new HttpHeaders({
      Authorization: 'Bearer ' + this.tokenStorageService.getToken(),
    }),
  };

  constructor(
    private http: HttpClient,
    private tokenStorageService: TokenStorageService
  ) {}

  getStudentByName(lastName: string) {
    return this.http.get(`${this.baseUrl}/name=${lastName}`, this.httpOptions);
  }

  getStudents() {
    return this.http.get(`${this.baseUrl}/list`, this.httpOptions);
  }

  getStudentById(StudentId: String) {
    return this.http.get(this.baseUrl + '/id=' + StudentId, this.httpOptions);
  }

  addStudent(student: any) {
    return this.http.post(this.baseUrl + '/new', student, this.httpOptions);
  }

  updateStudent(StudentId: number, newStudent: any) {
    return this.http.put(
      this.baseUrl + '/update/id=' + StudentId,
      newStudent,
      this.httpOptions
    );
  }

  deleteStudent(StudentId: number) {
    return this.http.delete(
      `${this.baseUrl}/delete/id= ${StudentId}`,
      this.httpOptions
    );
  }
}
