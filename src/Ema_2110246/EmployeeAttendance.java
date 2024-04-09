
package Ema_2110246;

import java.io.Serializable;
import java.time.LocalDate;


class EmployeeAttendance implements Serializable {
    private String desigCol;
    private float overtimecol;
    private LocalDate datecol;
    private String remarksCol;

    public EmployeeAttendance(String desigCol, String remarksCol, Float hoursValue, LocalDate datecol) {
        this.desigCol = desigCol;
        this.overtimecol = overtimecol;
        this.datecol = datecol;
        this.remarksCol = remarksCol;
    }

    public String getDesigCol() {
        return desigCol;
    }

    public void setDesigCol(String desigCol) {
        this.desigCol = desigCol;
    }

    public float getOvertimecol() {
        return overtimecol;
    }

    public void setOvertimecol(float overtimecol) {
        this.overtimecol = overtimecol;
    }

    public LocalDate getDatecol() {
        return datecol;
    }

    public void setDatecol(LocalDate datecol) {
        this.datecol = datecol;
    }

    public String getRemarksCol() {
        return remarksCol;
    }

    public void setRemarksCol(String remarksCol) {
        this.remarksCol = remarksCol;
    }

    @Override
    public String toString() {
        return "EmployeeAttendance{" + "desigCol=" + desigCol + ", overtimecol=" + overtimecol + ", datecol=" + datecol + ", remarksCol=" + remarksCol + '}';
    }

    

    
}
