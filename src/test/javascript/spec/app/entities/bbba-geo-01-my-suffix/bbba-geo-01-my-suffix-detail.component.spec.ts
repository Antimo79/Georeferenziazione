/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbbaGeo01MySuffixDetailComponent } from 'app/entities/bbba-geo-01-my-suffix/bbba-geo-01-my-suffix-detail.component';
import { BbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';

describe('Component Tests', () => {
    describe('BbbaGeo01MySuffix Management Detail Component', () => {
        let comp: BbbaGeo01MySuffixDetailComponent;
        let fixture: ComponentFixture<BbbaGeo01MySuffixDetailComponent>;
        const route = ({ data: of({ bbbaGeo01: new BbbaGeo01MySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbbaGeo01MySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BbbaGeo01MySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BbbaGeo01MySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.bbbaGeo01).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
