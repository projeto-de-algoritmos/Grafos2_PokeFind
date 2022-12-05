import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Pokemon} from "../pokemon-select/pokemons";


export interface DialogData {
  pokemon: Pokemon;
}


@Component({
  selector: 'app-modal-winner',
  templateUrl: './modal-winner.component.html',
  styleUrls: ['./modal-winner.component.css']
})

export class ModalWinnerComponent implements OnInit{
  constructor(
    public dialogRef: MatDialogRef<ModalWinnerComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,

  ) {}

  area: any = this.data

  onNoClick(): void {
    this.dialogRef.close();
  }

  print() {
    console.log(this.area)
  }

  ngOnInit(): void {
    console.log(this.area)
  }
}
