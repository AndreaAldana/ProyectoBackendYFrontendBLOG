import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { Usuario } from '../models/usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
  }

  contra:string;
  correo:string;

  loginUsuario(correo: string,contrasenha: string){
    if(!correo.trim()){
      alert("Campo correo vacio");
    }
    else if(!contrasenha.trim()){
      alert("Campo contraseña vacio");
    }


    else{
      this.usuarioService.loginUsuario({correo, contrasenha} as Usuario).subscribe(_ => { alert("Logueo exitoso"); this.router.navigate(['home'])},  error => {alert("Los datos no coinciden")});
        
    }
  }

}
