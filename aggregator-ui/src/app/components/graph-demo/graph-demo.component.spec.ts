import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GraphDemoComponent } from './graph-demo.component';

describe('GraphDemoComponent', () => {
  let component: GraphDemoComponent;
  let fixture: ComponentFixture<GraphDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GraphDemoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GraphDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
