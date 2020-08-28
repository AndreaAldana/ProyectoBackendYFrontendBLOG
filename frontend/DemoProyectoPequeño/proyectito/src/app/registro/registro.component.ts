import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { Usuario } from '../models/usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
  }

  usuario: Usuario[];
  rut: string;
  nombres: string;
  apellidos: string;
  fechaNacimiento: string;
  correo: string;
  contra: string;
  hasLower: boolean = false;
  hasUpper: boolean = false;
  hasNum: boolean = false;
    
 

  registrar(rut: string, nombres:string, apellidos:string, fechaNacimiento:string, correo:string, contrasenha: string): void{
    if(!rut){
      alert("Rut vacio");
      return;
    }
    if(!nombres){
      alert("Nombres vacio");
      return;
    } if (!apellidos){
      alert("Apellidos vacio");
      return;
    } if (!fechaNacimiento){
      alert("Fecha de nacimiento vacia");
      return;
    }
    if(!correo){
      alert("Correo vacio");
      return;
    } if (!contrasenha){
      alert("Contraseña vacio");
      return;
    } 
    if(contrasenha.length < 4){
      alert("la contraseña debe ser mayor a 4 caracteres");
      return;
    }
    
   
    const lowercaseRegex = new RegExp("(?=.*[a-z])");// Al menos una letra baja
    const numRegex = new RegExp("(?=.*\\d)"); // Que tenga al menos un num
    if (numRegex.test(contrasenha) && lowercaseRegex.test(contrasenha)) {
      this.hasNum = true;
      this.hasLower = true;
      
    
    }else{
      alert("La contraseña necesita tener al menos una letra y un número")
    }
  

    this.usuarioService.registro({rut, nombres, apellidos, fechaNacimiento, correo, contrasenha} as Usuario).subscribe(_ => {alert("Registro exitoso"); this.router.navigate(['home'])},
    error => {alert("Este correo ya se encuentra en uso")} );
  }

}


