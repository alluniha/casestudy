import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrioritizeTaskComponent } from './prioritize-task.component';

describe('PrioritizeTaskComponent', () => {
  let component: PrioritizeTaskComponent;
  let fixture: ComponentFixture<PrioritizeTaskComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrioritizeTaskComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrioritizeTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
