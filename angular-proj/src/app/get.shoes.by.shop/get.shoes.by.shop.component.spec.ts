import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetShoesByShopComponent } from './get.shoes.by.shop.component';

describe('GetShoesByShopComponent', () => {
  let component: GetShoesByShopComponent;
  let fixture: ComponentFixture<GetShoesByShopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetShoesByShopComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GetShoesByShopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
