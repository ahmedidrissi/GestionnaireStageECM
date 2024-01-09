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

  getEntrepriseBySiretNumber(siretNumber: number) {
    return this.http.get(
      `${this.baseUrl}/siret=${siretNumber}`,
      this.httpOptions
    );
  }

  getEntrepriseByBusinessName(businessName: string) {
    return this.http.get(
      `${this.baseUrl}/name=${businessName}`,
      this.httpOptions
    );
  }

  addEntreprise(entreprise: any) {
    return this.http.post(`${this.baseUrl}/new`, entreprise, this.httpOptions);
  }

  updateEntreprise(siretNumber: number, newEntreprise: any) {
    return this.http.put(
      `${this.baseUrl}/update/siret=${siretNumber}`,
      newEntreprise,
      this.httpOptions
    );
  }

  deleteEntreprise(siretNumber: number) {
    return this.http.delete(
      `${this.baseUrl}/delete/siret=${siretNumber}`,
      this.httpOptions
    );
  }
}
