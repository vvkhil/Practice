import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import Shoe from "../entities/shoe"
import { ShoeService } from '../services/shoe.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-shoe.update',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './shoe.update.component.html',
  styleUrl: './shoe.update.component.css'
})
export class ShoeUpdateComponent {
  shoe: Shoe = new Shoe();
  id: number;

  constructor(private shoeService: ShoeService, 
              private router: Router, 
              private activateRoute: ActivatedRoute) {
    this.id = activateRoute.snapshot.params["id"];
  }

  async ngOnInit(){
    this.shoe = await this.shoeService.getShoeById(this.id);
    console.log(this.shoe)
  }

  async updateShoe() {
    await this.shoeService.updateShoe(this.shoe);
    this.router.navigate(["/shoes"]);
  }
}
