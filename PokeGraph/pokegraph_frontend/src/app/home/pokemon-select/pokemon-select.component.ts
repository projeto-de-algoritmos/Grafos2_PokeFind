import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {PokemonService} from './pokemon.service';
import {Pokemon} from './pokemons';
import {MatSelectChange} from "@angular/material/select";
import {MatDialog} from "@angular/material/dialog";
import {ModalWinnerComponent} from "../modal-winner/modal-winner.component";
import {AreaService} from "./area.service";
import {Area} from "./areas";


@Component({
  selector: 'app-pokemon-select',
  templateUrl: './pokemon-select.component.html',
  styleUrls: ['./pokemon-select.component.css']
})
export class PokemonSelectComponent implements OnInit {

  optionsPokemon: any[] = [];
  optionsAreas: any[] = [];
  imageAlt: any;
  imageSourceSelf: any;
  imageSourceOther: any;
  firstPokemon: any = null;
  secondPokemon: any = null;

  pokemonForm = this.formBuilder.group({
    pokemon1: '',
    pokemon2: '',
  });

  constructor(
    private areaService: AreaService,
    private pokemonService: PokemonService,
    private formBuilder: FormBuilder,
    public dialog: MatDialog,
  ) {

  }

  ngOnInit(): void {

    this.pokemonService.listPokemon().subscribe((response: any) => {
      response.map((pokemon: Pokemon) => {
        this.extractPokemon(pokemon);
      });
      this.optionsPokemon = response
      console.log(this.optionsPokemon)
    });

    this.areaService.listArea().subscribe((response: any) => {
      response.map((area: Area) => {
        this.extractArea(area);
      });
      this.optionsAreas = response;
    })
  }

  openDialog(response: any): void {
    const dialogRef = this.dialog.open(ModalWinnerComponent, {
      width: '500px',
      height: '500px',
      data: response,
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  extractPokemon(pokemon: Pokemon) {
    return {
      id: pokemon.id,
      name: pokemon.name,
      url: pokemon.url
    };
  }

  extractArea(area: Area) {
    return {
      id: area.id,
      name: area.name
    };
  }


  loadPokemonSelf($event: MatSelectChange) {
    if($event.value !== null){
      this.imageSourceSelf = $event.value.url
      this.firstPokemon = $event.value.id
    } else {
      this.firstPokemon = $event.value
    }
  }
  loadPokemonOther($event: MatSelectChange) {
    if($event.value !== null){
      this.imageSourceOther = $event.value.url
      this.secondPokemon = $event.value.id
    } else {
      this.secondPokemon = $event.value
    }
  }

  battle() {
    this.pokemonService.battlePokemon(this.firstPokemon, this.secondPokemon).subscribe((response: any) => {
      this.openDialog(response);
    });

  }
}
