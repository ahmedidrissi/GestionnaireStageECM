import { Injectable } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root',
})
export class EtudiantsService {
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

  getEtudiantName(lastName: string) {
    return this.http.get(`${this.baseUrl}/name=${lastName}`, this.httpOptions);
  }

  getEtudiants() {
    return this.http.get(`${this.baseUrl}/list`, this.httpOptions);
  }

  getEtudiantsById(StudentId: String) {
    return this.http.get(this.baseUrl + '/id=' + StudentId, this.httpOptions);
  }

  addEtudiants(etudiant: any) {
    return this.http.post(this.baseUrl + '/new', etudiant, this.httpOptions);
  }

  updateEtudiants(StudentId: number, newEtudiants: any) {
    return this.http.put(
      this.baseUrl + '/update/id=' + StudentId,
      newEtudiants,
      this.httpOptions
    );
  }

  deleteEtudiant(StudentId: number) {
    return this.http.delete(
      `${this.baseUrl}/delete/id= ${StudentId}`,
      this.httpOptions
    );
  }
}
