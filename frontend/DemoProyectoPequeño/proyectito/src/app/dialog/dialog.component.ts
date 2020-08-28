import { Component, OnInit, Inject } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { Usuario } from '../models/usuario';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {
  user: any;

  constructor(private usuarioService: UsuarioService,  private dialogRef: MatDialogRef<DialogComponent>,
    @Inject(MAT_DIALOG_DATA) data){this.user = data}

  
  ngOnInit(): void {
  }
  
  guardar(){
    this.usuarioService.editarCuentaUsuario(this.user).subscribe(data => console.log(data))
  }
}
