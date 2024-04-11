import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveShoeFromShopComponent } from './remove.shoe.from.shop.component';

describe('RemoveShoeFromShopComponent', () => {
  let component: RemoveShoeFromShopComponent;
  let fixture: ComponentFixture<RemoveShoeFromShopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RemoveShoeFromShopComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RemoveShoeFromShopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
