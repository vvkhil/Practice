import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopUpdateComponent } from './shop.update.component';

describe('ShopUpdateComponent', () => {
  let component: ShopUpdateComponent;
  let fixture: ComponentFixture<ShopUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShopUpdateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShopUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
