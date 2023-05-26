import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']

})
export class AuthComponent {

  loginForm : FormGroup;

  constructor(private _auth : AuthService, private _router : Router) {
    this.loginForm = new FormGroup({
      email : new FormControl('', [Validators.required]),
      password : new FormControl('', Validators.required)
    })
  }

  submitLogin() {
    this._auth.login(this.loginForm.value['email'], this.loginForm.value['password']).subscribe({
      next : () => {
        this._router.navigateByUrl('/');
      }
    });
    //console.log(this.loginForm.value['email'] +" "+ this.loginForm.value['password'])
  }

}
