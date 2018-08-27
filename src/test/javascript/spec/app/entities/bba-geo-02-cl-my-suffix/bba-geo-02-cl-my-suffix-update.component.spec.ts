/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbaGeo02ClMySuffixUpdateComponent } from 'app/entities/bba-geo-02-cl-my-suffix/bba-geo-02-cl-my-suffix-update.component';
import { BbaGeo02ClMySuffixService } from 'app/entities/bba-geo-02-cl-my-suffix/bba-geo-02-cl-my-suffix.service';
import { BbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';

describe('Component Tests', () => {
    describe('BbaGeo02ClMySuffix Management Update Component', () => {
        let comp: BbaGeo02ClMySuffixUpdateComponent;
        let fixture: ComponentFixture<BbaGeo02ClMySuffixUpdateComponent>;
        let service: BbaGeo02ClMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbaGeo02ClMySuffixUpdateComponent]
            })
                .overrideTemplate(BbaGeo02ClMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BbaGeo02ClMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BbaGeo02ClMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BbaGeo02ClMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bbaGeo02Cl = entity;
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
                    const entity = new BbaGeo02ClMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bbaGeo02Cl = entity;
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
