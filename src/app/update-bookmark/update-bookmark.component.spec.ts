import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBookmarkComponent } from './update-bookmark.component';

describe('UpdateBookmarkComponent', () => {
  let component: UpdateBookmarkComponent;
  let fixture: ComponentFixture<UpdateBookmarkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateBookmarkComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateBookmarkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
