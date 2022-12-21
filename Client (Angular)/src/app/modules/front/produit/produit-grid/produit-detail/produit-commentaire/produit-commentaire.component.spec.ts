import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitCommentaireComponent } from './produit-commentaire.component';

describe('ProduitCommentaireComponent', () => {
  let component: ProduitCommentaireComponent;
  let fixture: ComponentFixture<ProduitCommentaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduitCommentaireComponent ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProduitCommentaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
