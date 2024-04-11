import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoeAddComponent } from './shoe.add.component';

describe('ShoeAddComponent', () => {
  let component: ShoeAddComponent;
  let fixture: ComponentFixture<ShoeAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShoeAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShoeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
