@REM Maven Wrapper script for Windows
@REM Descarga Maven 3.9.0 si no existe y lo ejecuta

@echo off
setlocal enabledelayedexpansion

set MAVEN_HOME=%~dp0.mvn\maven-3.9.0
set MAVEN_CMD=%MAVEN_HOME%\bin\mvn.cmd

if not exist "%~dp0.mvn" (
    mkdir "%~dp0.mvn"
)

if not exist "!MAVEN_HOME!" (
    echo Descargando Maven 3.9.0...
    powershell -NoProfile -ExecutionPolicy Bypass -Command ^
        $ProgressPreference = 'SilentlyContinue'; ^
        Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/3.9.0/binaries/apache-maven-3.9.0-bin.zip' -OutFile '%~dp0.mvn\maven.zip'; ^
        Expand-Archive -Path '%~dp0.mvn\maven.zip' -DestinationPath '%~dp0.mvn'; ^
        Rename-Item -Path '%~dp0.mvn\apache-maven-3.9.0' -NewName 'maven-3.9.0'; ^
        Remove-Item -Path '%~dp0.mvn\maven.zip'
)

if not exist "!MAVEN_CMD!" (
    echo Error: No se pudo encontrar o descargar Maven.
    exit /b 1
)

"!MAVEN_CMD!" %*
endlocal
