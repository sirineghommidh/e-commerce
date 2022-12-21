import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitGridComponent } from './produit-grid.component';

describe('ProduitGridComponent', () => {
  let component: ProduitGridComponent;
  let fixture: ComponentFixture<ProduitGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduitGridComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProduitGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
