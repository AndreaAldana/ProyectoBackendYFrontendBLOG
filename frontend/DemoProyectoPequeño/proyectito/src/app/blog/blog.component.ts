import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  mensaje = '';
  listMensajes: any[]=[]; 
  agregarMensaje(){

    console.log(this.mensaje);
    const tarea = {nombre: this.mensaje, finalizada: false}
    this.listMensajes.push(tarea);
    console.log(this.listMensajes);
    this.mensaje ='';
  }

  eliminarMensaje(index: number){
  this.listMensajes.splice(index, 1);
  }

}
