import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitRechAvComponent } from './produit-rech-av.component';

describe('ProduitRechAvComponent', () => {
  let component: ProduitRechAvComponent;
  let fixture: ComponentFixture<ProduitRechAvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduitRechAvComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProduitRechAvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
