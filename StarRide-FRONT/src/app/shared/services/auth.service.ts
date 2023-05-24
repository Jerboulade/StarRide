import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private _http : HttpClient, private _auth : AuthService) { }

  login(email : string, password : string) : Observable<any> {
    return this._http.post<{ token : string, username : string }>(`${ environment.base_uri }`, { email, password }).pipe(
      tap(data => this._auth.login(data.email, data.password))
    )
  }
}
