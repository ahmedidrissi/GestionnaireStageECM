import { Injectable } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private baseUrl = AppComponent.baseUrl + '/auth/authenticate';

  constructor(private http: HttpClient) {}

  authenticate(email: string, password: string) {
    return this.http
      .post(this.baseUrl, {
        email: email,
        password: password,
      })
      .pipe(
        map((res: any) => {
          sessionStorage.setItem('token', res.token);
        })
      );
  }
}
