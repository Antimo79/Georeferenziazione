/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbaGeo02ClMySuffixDeleteDialogComponent } from 'app/entities/bba-geo-02-cl-my-suffix/bba-geo-02-cl-my-suffix-delete-dialog.component';
import { BbaGeo02ClMySuffixService } from 'app/entities/bba-geo-02-cl-my-suffix/bba-geo-02-cl-my-suffix.service';

describe('Component Tests', () => {
    describe('BbaGeo02ClMySuffix Management Delete Component', () => {
        let comp: BbaGeo02ClMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<BbaGeo02ClMySuffixDeleteDialogComponent>;
        let service: BbaGeo02ClMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbaGeo02ClMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(BbaGeo02ClMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BbaGeo02ClMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BbaGeo02ClMySuffixService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
