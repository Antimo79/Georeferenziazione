/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { CutcUtzUbicMySuffixUpdateComponent } from 'app/entities/cutc-utz-ubic-my-suffix/cutc-utz-ubic-my-suffix-update.component';
import { CutcUtzUbicMySuffixService } from 'app/entities/cutc-utz-ubic-my-suffix/cutc-utz-ubic-my-suffix.service';
import { CutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';

describe('Component Tests', () => {
    describe('CutcUtzUbicMySuffix Management Update Component', () => {
        let comp: CutcUtzUbicMySuffixUpdateComponent;
        let fixture: ComponentFixture<CutcUtzUbicMySuffixUpdateComponent>;
        let service: CutcUtzUbicMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [CutcUtzUbicMySuffixUpdateComponent]
            })
                .overrideTemplate(CutcUtzUbicMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(CutcUtzUbicMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CutcUtzUbicMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new CutcUtzUbicMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.cutcUtzUbic = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new CutcUtzUbicMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.cutcUtzUbic = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
