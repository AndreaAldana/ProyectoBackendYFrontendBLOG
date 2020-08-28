import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { Usuario } from '../models/usuario';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import { MatTableDataSource } from '@angular/material/table';
import { SelectionModel } from '@angular/cdk/collections';
import { Router } from '@angular/router';
@Component({
  selector: 'app-tabla',
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.css']
})
export class TablaComponent implements OnInit {

  constructor(private usuarioService: UsuarioService, public dialog: MatDialog, private router: Router) { }

  
  usuario: Usuario[] = [];
  columnas = ["rut", "nombres", "apellidos", "fechaNacimiento", "correo", "contrasenha", "boton", "boton1"]
  dataSource = new MatTableDataSource<Usuario>(this.usuario);
  

  ngOnInit(): void {
   this.usuarioService.mostrarUsuarios().subscribe(usuario => this.usuario = usuario);
  }

  
  openDialog(user){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = user;
    this.dialog.open(DialogComponent, dialogConfig);
  }

  borrar(i){
    const rut = this.usuario[i].rut

    this.usuarioService.borrarUser(rut).subscribe(_=>this.obtenerUserAct());

}

obtenerUserAct() {
  this.usuarioService.mostrarUsuarios()
    .subscribe(usuarios => this.usuario = usuarios);
}



}

/* borrar(rut: string, index: number){
  this.usuario.splice(index,);
  this.usuarioService.borrarUser(rut)
    .subscribe(_ => {});
} */