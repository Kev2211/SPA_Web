import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';

import { CiudadService } from './services/ciudad/ciudad.service';
import { PersonasService } from './services/personas/personas.service';
import { TipodocumentoService } from 'src/app/services/tipodocumento/tipodocumento.service';
import { CRUDServiceService } from './crudservice.service';
import { Persona } from './models/Persona';
import { MatPaginator } from '@angular/material/paginator';
import { error } from 'console';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'CRUD-APP';

  dataSource: any;
  messageInfo: string;
  mostrarAlerta: boolean;

  personaForm: FormGroup;
  tipodocumento: any;
  ciudad:any;
  persona:any;

  ngOnInit() {
    this.personaForm = this.fb.group({
      id : [''],
      name : ['', Validators.required],
      apellidos : ['', Validators.required],
      documento : ['', Validators.required],
      fechanacimento  : ['', Validators.required],
      email  : ['', Validators.required],
      telefono  : ['', Validators.required],
      usuario  : ['', Validators.required],
      contrasena : ['', Validators.required],
      ciudad : ['', Validators.required],
      tipodocumento : ['', Validators.required],
    });

    this.tipodocumentoService.getAllTipodocumento().subscribe(resp=>{
        this.tipodocumento = resp;
        console.log(resp);
    }, 
    error=>{console.error(error)})

    this.messageInfo = "Persona agregada correctamente :)";
    this.mostrarAlerta = false;

    /*this.CRUDServiceService.getAll(0, 10, false).subscribe(res => {
      this.dataSource = new MatTableDataSource<Persona>(res.content);
      this.dataSource.paginator = this.paginator;
    },
      error => { console.log(error) }
    ) */

    this.ciudadService.getAllCiudad().subscribe(resp=>{
      this.ciudad = resp;
      console.log(resp);
    },
    error=>{console.error(error)})

    this.personaService.getAllPersona().subscribe(resp=>{
      this.persona = resp;
      console.log(resp);
    },
    error=>{console.error(error)})

  }

  constructor(
    public fb: FormBuilder,
    private router: Router,
    private CRUDServiceService: CRUDServiceService,
    public tipodocumentoService : TipodocumentoService,
    public ciudadService : CiudadService,
    public personaService : PersonasService
  ) { }
  /* 
    submitForm() {
    this.mostrarAlerta = true;
    this.CRUDServiceService.save(this.personaForm.value).subscribe(
      res => {
        this.dataSource.push(res);
        this.personaForm.reset();
      },
      error => {
        console.log("No se pudo guardar el producto: " + error);
        console.error(error);
        this.messageInfo = "No se pudo guardar la persona: " + error.message;
      }
    );
    }
  */


  cerrarAlerta() {
    this.mostrarAlerta = false;
  }


  /* 
    delete(persona: any) {
    this.CRUDServiceService.delete(persona).subscribe(res => {
      this.dataSource.pop(res);
    },
    )
  }
  */

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;

  guardar():void{
    this.personaService.savePersona(this.personaForm.value).subscribe(resp=>{
        this.personaForm.reset();
        this.persona = this.persona.filter(persona=> resp.id!=persona.id);
        this.persona.push(resp);
    },
      error=>{console.error(error)})
  }

  eliminar(persona){
    this.personaService.deletePersona(persona.id).subscribe(resp => {
      console.log(resp);
      if(resp === true){
        this.persona.pop(persona);
      }
    });
    
  }

  editar(persona){
    this.personaForm.setValue({
      id : persona.id,
      name : persona.name,
      apellidos : persona.apellido,
      documento : persona.documento,
      fechanacimento  : persona.fechanacimento,
      email  : persona.email,
      telefono  : persona.telefono,
      usuario  : persona.usuario,
      contrasena : persona.contrasena,
      ciudad : persona.ciudad,
      tipodocumento : persona.tipodocumento,
    })
  }

}
