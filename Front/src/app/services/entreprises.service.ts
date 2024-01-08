import { Injectable } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root',
})
export class EntreprisesService {
  private baseUrl = AppComponent.baseUrl + '/entreprises';

  constructor(
    private http: HttpClient,
    private tokenStorageService: TokenStorageService
  ) {}

  getEntreprises() {
    return this.http.get(this.baseUrl + '/list', {
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + this.tokenStorageService.getToken(),
      }),
    });
  }
}
