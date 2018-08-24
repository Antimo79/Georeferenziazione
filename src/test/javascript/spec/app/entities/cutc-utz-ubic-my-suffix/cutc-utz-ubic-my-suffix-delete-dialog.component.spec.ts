/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { CutcUtzUbicMySuffixDeleteDialogComponent } from 'app/entities/cutc-utz-ubic-my-suffix/cutc-utz-ubic-my-suffix-delete-dialog.component';
import { CutcUtzUbicMySuffixService } from 'app/entities/cutc-utz-ubic-my-suffix/cutc-utz-ubic-my-suffix.service';

describe('Component Tests', () => {
    describe('CutcUtzUbicMySuffix Management Delete Component', () => {
        let comp: CutcUtzUbicMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<CutcUtzUbicMySuffixDeleteDialogComponent>;
        let service: CutcUtzUbicMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [CutcUtzUbicMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(CutcUtzUbicMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(CutcUtzUbicMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CutcUtzUbicMySuffixService);
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
