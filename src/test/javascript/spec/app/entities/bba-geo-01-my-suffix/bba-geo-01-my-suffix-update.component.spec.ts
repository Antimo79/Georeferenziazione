/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbaGeo01MySuffixUpdateComponent } from 'app/entities/bba-geo-01-my-suffix/bba-geo-01-my-suffix-update.component';
import { BbaGeo01MySuffixService } from 'app/entities/bba-geo-01-my-suffix/bba-geo-01-my-suffix.service';
import { BbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';

describe('Component Tests', () => {
    describe('BbaGeo01MySuffix Management Update Component', () => {
        let comp: BbaGeo01MySuffixUpdateComponent;
        let fixture: ComponentFixture<BbaGeo01MySuffixUpdateComponent>;
        let service: BbaGeo01MySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbaGeo01MySuffixUpdateComponent]
            })
                .overrideTemplate(BbaGeo01MySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BbaGeo01MySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BbaGeo01MySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BbaGeo01MySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bbaGeo01 = entity;
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
                    const entity = new BbaGeo01MySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bbaGeo01 = entity;
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
