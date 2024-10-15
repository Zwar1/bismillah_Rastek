package Rastek_fix.demo.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class EmployeeReq {
    // Personal Information fields
    private String name;
    private String no_ktp;
    private String NPWP;
    private String kartuKeluarga;
    private String jenisKelamin;
    private String tempatLahir;
    private String tanggalLahir;
    private String agama;
    private String alamatLengkap;
    private String alamatDomisili;
    private String noTelp;
    private String kontakDarurat;
    private String noKontakDarurat;
    private String emailPribadi;
    private String pendidikanTerakhir;
    private String jurusan;
    private String namaUniversitas;
    private String namaIbuKandung;
    private String statusPernikahan;
    private String jumlahAnak;
    private String nomorRekening;
    private String bank;


    // Basic Information fields
    private String statusKontrak;
    private String tmt_awal;
    private String tmt_akhir;
    private String kontrakKedua;
    private BigDecimal salary;
    private String attachment;

    // Department info
    private Long departementId; // ID dari DepartementEntity

    // Division info
    private Long divisionId; // ID dari DivisionEntity

    // SubDivision info
    private Long subDivisionId; // ID dari SubDivisionEntity

    // Jabatan info
    private List<Long> jabatanIds; // Set ID dari JabatanEntity

}
