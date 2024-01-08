import { Injectable } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private baseUrl = AppComponent.baseUrl + '/auth/authenticate';

  constructor(private http: HttpClient) {}

  authenticate(email: string, password: string) {
    this.http
      .post(this.baseUrl, {
        email: email,
        password: password,
      })
      .subscribe((response: any) => {
        console.log(response);
      });
  }
}
