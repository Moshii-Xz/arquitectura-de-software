package com.agrointeligente.usuario.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.agrointeligente.entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil")
public class PerfilEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false, updatable = false)
    private UUID id;

    @OneToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private UserEntity usuario;

    @Column(length = 120)
    private String municipio;

    @Column(length = 120)
    private String vereda;

    @Column(length = 120)
    private String finca;

    @Column(length = 20)
    private String telefono;

    @Column(length = 20)
    private String idioma = "es";

    @Column(name = "foto_url", length = 500)
    private String fotoUrl;

    @Column
    private Double latitud;

    @Column
    private Double longitud;

    @Column(name = "notificacion_push", nullable = false)
    private boolean notificacionPush = true;

    @Column(name = "notificacion_email", nullable = false)
    private boolean notificacionEmail = true;

    @Column(name = "notificacion_sms", nullable = false)
    private boolean notificacionSms = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getVereda() {
        return vereda;
    }

    public void setVereda(String vereda) {
        this.vereda = vereda;
    }

    public String getFinca() {
        return finca;
    }

    public void setFinca(String finca) {
        this.finca = finca;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public boolean isNotificacionPush() {
        return notificacionPush;
    }

    public void setNotificacionPush(boolean notificacionPush) {
        this.notificacionPush = notificacionPush;
    }

    public boolean isNotificacionEmail() {
        return notificacionEmail;
    }

    public void setNotificacionEmail(boolean notificacionEmail) {
        this.notificacionEmail = notificacionEmail;
    }

    public boolean isNotificacionSms() {
        return notificacionSms;
    }

    public void setNotificacionSms(boolean notificacionSms) {
        this.notificacionSms = notificacionSms;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}