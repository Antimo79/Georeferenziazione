/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { CutcUtzUbicMySuffixComponent } from 'app/entities/cutc-utz-ubic-my-suffix/cutc-utz-ubic-my-suffix.component';
import { CutcUtzUbicMySuffixService } from 'app/entities/cutc-utz-ubic-my-suffix/cutc-utz-ubic-my-suffix.service';
import { CutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';

describe('Component Tests', () => {
    describe('CutcUtzUbicMySuffix Management Component', () => {
        let comp: CutcUtzUbicMySuffixComponent;
        let fixture: ComponentFixture<CutcUtzUbicMySuffixComponent>;
        let service: CutcUtzUbicMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [CutcUtzUbicMySuffixComponent],
                providers: []
            })
                .overrideTemplate(CutcUtzUbicMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(CutcUtzUbicMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CutcUtzUbicMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new CutcUtzUbicMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.cutcUtzUbics[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
