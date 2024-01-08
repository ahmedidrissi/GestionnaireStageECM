import { Injectable } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root',
})
export class EntreprisesService {
  private baseUrl = AppComponent.baseUrl + '/entreprises';
  private httpOptions = {
    headers: new HttpHeaders({
      Authorization: 'Bearer ' + this.tokenStorageService.getToken(),
    }),
  };

  constructor(
    private http: HttpClient,
    private tokenStorageService: TokenStorageService
  ) {}

  getEntreprises() {
    return this.http.get(`${this.baseUrl}/list`, this.httpOptions);
  }

  getEntrepriseById(entrepriseId: number) {
    return this.http.get(
      `${this.baseUrl}/id=${entrepriseId}`,
      this.httpOptions
    );
  }

  addEntreprise(entreprise: any) {
    return this.http.post(`${this.baseUrl}/new`, entreprise, this.httpOptions);
  }

  updateEntreprise(siretNumber: number, newEntreprise: any) {
    return this.http.put(
      `${this.baseUrl}/update/id=${siretNumber}`,
      newEntreprise,
      this.httpOptions
    );
  }

  deleteEntreprise(siretNumber: number) {
    return this.http.delete(
      `${this.baseUrl}/delete/id=${siretNumber}`,
      this.httpOptions
    );
  }
}
