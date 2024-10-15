package Rastek_fix.demo.Service;

import Rastek_fix.demo.DTO.EmployeeRes;
import Rastek_fix.demo.DTO.EmployeeReq;
import Rastek_fix.demo.DTO.UpdateEmployeeReq;
import Rastek_fix.demo.Entity.*;
import Rastek_fix.demo.Repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    private RiwayatJabatanRepository riwayatJabatanRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private SubDivisionRepository subDivisionRepository;

    @Autowired
    private JabatanRepository jabatanRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public EmployeeRes create(EmployeeReq request){
        validationService.validate(request);

        EmployeeEntity employee = new EmployeeEntity();

        employee.setName(request.getName());
        employee.setNo_ktp(request.getNo_ktp());
        employee.setNPWP(request.getNPWP());
        employee.setKartuKeluarga(request.getKartuKeluarga());
        employee.setJenisKelamin(request.getJenisKelamin());
        employee.setTempatLahir(request.getTempatLahir());
        employee.setAgama(request.getAgama());
        employee.setAlamatLengkap(request.getAlamatLengkap());
        employee.setAlamatDomisili(request.getAlamatDomisili());
        employee.setNoTelp(request.getNoTelp());
        employee.setKontakDarurat(request.getKontakDarurat());
        employee.setNoKontakDarurat(request.getNoKontakDarurat());
        employee.setEmailPribadi(request.getEmailPribadi());
        employee.setPendidikanTerakhir(request.getPendidikanTerakhir());
        employee.setJurusan(request.getJurusan());
        employee.setNamaUniversitas(request.getNamaUniversitas());
        employee.setNamaIbuKandung(request.getNamaIbuKandung());
        employee.setStatusPernikahan(request.getStatusPernikahan());
        employee.setJumlahAnak(request.getJumlahAnak());
        employee.setNomorRekening(request.getNomorRekening());
        employee.setBank(request.getBank());

        RiwayatJabatanEntity riwayatJabatan = new RiwayatJabatanEntity();

        riwayatJabatan.setStatusKontrak(request.getStatusKontrak());
        riwayatJabatan.setTmt_mulai(request.getTmt_akhir());
        riwayatJabatan.setTmt_akhir(request.getTmt_akhir());
        riwayatJabatan.setKontrakKedua(request.getKontrakKedua());
        riwayatJabatan.setSalary(request.getSalary());
        riwayatJabatan.setAttachment(request.getAttachment());

        // Set DepartementEntity
        if (request.getDepartementId() != null) {
            DepartementEntity departementEntity = departementRepository.findById(request.getDepartementId())
                    .orElseThrow(() -> new EntityNotFoundException("Departement not found"));
            riwayatJabatan.setDepartementEntity(departementEntity);
        }

        // Set DivisionEntity
        if (request.getDivisionId() != null) {
            DivisionEntity divisionEntity = divisionRepository.findById(request.getDivisionId())
                    .orElseThrow(() -> new EntityNotFoundException("Division not found"));
            riwayatJabatan.setDivisionEntity(divisionEntity);
        }

        // Set SubDivisionEntity
        if (request.getSubDivisionId() != null) {
            SubDivisionEntity subDivisionEntity = subDivisionRepository.findById(request.getSubDivisionId())
                    .orElseThrow(() -> new EntityNotFoundException("SubDivision not found"));
            riwayatJabatan.setSubDivisionEntity(subDivisionEntity);
        }

        // Set JabatanEntities
        List<JabatanEntity> jabatanEntities = new ArrayList<>();
        for (Long jabatanId : request.getJabatanIds()) {
            JabatanEntity jabatanEntity = new JabatanEntity();
            jabatanEntity.setId(jabatanId);
            jabatanEntities.add(jabatanEntity);
        }
        riwayatJabatan.setJabatanEntities(jabatanEntities);

        // Save basicInfoEntity and return response

        riwayatJabatanRepository.save(riwayatJabatan);


        employee.setRiwayatJabatan(riwayatJabatan);

        employeeRepository.save(employee);

        return toEmployeeResponse(employee);
    }

    @Transactional(readOnly = true)
    public EmployeeRes get(Long NIK){
        EmployeeEntity employeeEntity = employeeRepository.findFirstByNIK(NIK)
                .orElseThrow(()->new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "Employee Not Found"));

        return toEmployeeResponse(employeeEntity);
    }

    @Transactional
    public  EmployeeRes update(UpdateEmployeeReq request){

        validationService.validate(request);

        EmployeeEntity employeeEntity = employeeRepository.findFirstByNIK(request.getNIK())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

        RiwayatJabatanEntity riwayatJabatan = new RiwayatJabatanEntity();

        riwayatJabatan.setStatusKontrak(request.getStatusKontrak());
        riwayatJabatan.setTmt_mulai(request.getTmt_awal());
        riwayatJabatan.setTmt_akhir(request.getTmt_akhir());
        riwayatJabatan.setKontrakKedua(request.getKontrakKedua());
        riwayatJabatan.setSalary(request.getSalary());
        riwayatJabatan.setAttachment(request.getAttachment());

        riwayatJabatanRepository.save(riwayatJabatan);

        EmployeeEntity employee = new EmployeeEntity();

        employee.setName(request.getName());
        employee.setNo_ktp(request.getNo_ktp());
        employee.setNPWP(request.getNPWP());
        employee.setKartuKeluarga(request.getKartuKeluarga());
        employee.setJenisKelamin(request.getJenisKelamin());
        employee.setTempatLahir(request.getTempatLahir());
        employee.setAgama(request.getAgama());
        employee.setAlamatLengkap(request.getAlamatLengkap());
        employee.setAlamatDomisili(request.getAlamatDomisili());
        employee.setNoTelp(request.getNoTelp());
        employee.setKontakDarurat(request.getKontakDarurat());
        employee.setNoKontakDarurat(request.getNoKontakDarurat());
        employee.setEmailPribadi(request.getEmailPribadi());
        employee.setPendidikanTerakhir(request.getPendidikanTerakhir());
        employee.setJurusan(request.getJurusan());
        employee.setNamaUniversitas(request.getNamaUniversitas());
        employee.setNamaIbuKandung(request.getNamaIbuKandung());
        employee.setStatusPernikahan(request.getStatusPernikahan());
        employee.setJumlahAnak(request.getJumlahAnak());
        employee.setNomorRekening(request.getNomorRekening());
        employee.setBank(request.getBank());

        employeeEntity.setRiwayatJabatan(riwayatJabatan);

        employeeRepository.save(employeeEntity);

        return toEmployeeResponse(employeeEntity);
    }

    private EmployeeRes toEmployeeResponse(EmployeeEntity employeeEntity) {

        RiwayatJabatanEntity riwayatJabatan = employeeEntity.getRiwayatJabatan();

        return EmployeeRes.builder()
                .NIK(employeeEntity.getNIK())
                .name(employeeEntity.getName())
                .no_ktp(employeeEntity.getNo_ktp())
                .NPWP(employeeEntity.getNPWP())
                .kartuKeluarga(employeeEntity.getKartuKeluarga())
                .jenisKelamin(employeeEntity.getJenisKelamin())
                .tempatLahir(employeeEntity.getTempatLahir())
                .agama(employeeEntity.getAgama())
                .alamatLengkap(employeeEntity.getAlamatLengkap())
                .alamatDomisili(employeeEntity.getAlamatDomisili())
                .noTelp(employeeEntity.getNoTelp())
                .kontakDarurat(employeeEntity.getKontakDarurat())
                .noKontakDarurat(employeeEntity.getNoKontakDarurat())
                .emailPribadi(employeeEntity.getEmailPribadi())
                .pendidikanTerakhir(employeeEntity.getPendidikanTerakhir())
                .jurusan(employeeEntity.getJurusan())
                .namaUniversitas(employeeEntity.getNamaUniversitas())
                .namaIbuKandung(employeeEntity.getNamaIbuKandung())
                .statusPernikahan(employeeEntity.getStatusPernikahan())
                .jumlahAnak(employeeEntity.getJumlahAnak())
                .nomorRekening(employeeEntity.getNomorRekening())
                .bank(employeeEntity.getBank())
                .statusKontrak(riwayatJabatan.getStatusKontrak())
                .tmt_awal(riwayatJabatan.getTmt_mulai())
                .tmt_akhir(riwayatJabatan.getTmt_akhir())
                .kontrakKedua(riwayatJabatan.getKontrakKedua())
                .salary(riwayatJabatan.getSalary())
                .attachment(riwayatJabatan.getAttachment())
                .build();
    }

}
