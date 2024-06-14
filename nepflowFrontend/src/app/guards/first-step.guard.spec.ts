import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { firstStepGuard } from './first-step.guard';

describe('firstStepGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => firstStepGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
