/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbbaGeo01MySuffixUpdateComponent } from 'app/entities/bbba-geo-01-my-suffix/bbba-geo-01-my-suffix-update.component';
import { BbbaGeo01MySuffixService } from 'app/entities/bbba-geo-01-my-suffix/bbba-geo-01-my-suffix.service';
import { BbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';

describe('Component Tests', () => {
    describe('BbbaGeo01MySuffix Management Update Component', () => {
        let comp: BbbaGeo01MySuffixUpdateComponent;
        let fixture: ComponentFixture<BbbaGeo01MySuffixUpdateComponent>;
        let service: BbbaGeo01MySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbbaGeo01MySuffixUpdateComponent]
            })
                .overrideTemplate(BbbaGeo01MySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BbbaGeo01MySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BbbaGeo01MySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BbbaGeo01MySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bbbaGeo01 = entity;
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
                    const entity = new BbbaGeo01MySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.bbbaGeo01 = entity;
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
