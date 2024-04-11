import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddShoeToShopComponent } from './add.shoe.to.shop.component';

describe('AddShoeToShopComponent', () => {
  let component: AddShoeToShopComponent;
  let fixture: ComponentFixture<AddShoeToShopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddShoeToShopComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddShoeToShopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
