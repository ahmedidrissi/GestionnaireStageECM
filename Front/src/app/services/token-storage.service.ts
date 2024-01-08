import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  clear(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem('token');
    window.sessionStorage.setItem('token', token);
  }

  public getToken(): string | null {
    return window.sessionStorage.getItem('token');
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem('user');
    window.sessionStorage.setItem('user', JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem('user');
    if (user) {
      return JSON.parse(user);
    }
    return {};
  }
}
