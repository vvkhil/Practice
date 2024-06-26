import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopAddComponent } from './shop.add.component';

describe('ShopAddComponent', () => {
  let component: ShopAddComponent;
  let fixture: ComponentFixture<ShopAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShopAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShopAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
