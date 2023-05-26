import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private _http : HttpClient, private _session : SessionService) { }

  login(email : string, password : string) : Observable<any> {
    //console.log(`${ environment.base_uri }/auth/login`);

    return this._http.post<{ token : string, username : string }>(`${ environment.base_uri }/auth/login`, { username: email, password: password }).pipe(
      tap(data => this._session.login({ token : data.token, id : data.username }))
    )
  }

  logout() {
    this._session.logout();
  }

  register(){}
}
