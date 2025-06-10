import platform
import re
import subprocess


def get_platform() -> str:
    system = platform.system().lower()
    machine = platform.machine().lower()

    if system == 'linux':
        if 'x86_64' in machine:
            return 'linux64'
    elif system == 'darwin':
        if 'arm' in machine:
            return 'mac-arm64'
        elif 'x86_64' in machine:
            return 'mac-x64'
    elif system == 'windows':
        if 'amd64' in machine or 'x86_64' in machine:
            return 'win64'
        elif 'x86' in machine:
            return 'win32'

    return 'unknown'


def get_chrome_version() -> str:
    """
    Get the version of Chrome installed on the system.
    Returns:
        str: Chrome version (e.g., '120.0.6099.109')
    """
    platform_name = get_platform()
    
    try:
        if platform_name == 'win64':
            # Windows: Check registry for Chrome version
            cmd = r'reg query "HKEY_CURRENT_USER\Software\Google\Chrome\BLBeacon" /v version'
            result = subprocess.run(cmd, capture_output=True, text=True, shell=True)
            if result.returncode == 0:
                version_match = re.search(r'version\s+REG_SZ\s+([\d.]+)', result.stdout)
                if version_match:
                    return version_match.group(1)
        
        elif platform_name == 'linux64':
            # Linux: Check using google-chrome --version
            cmd = 'google-chrome --version'
            result = subprocess.run(cmd, capture_output=True, text=True, shell=True)
            if result.returncode == 0:
                version_match = re.search(r'Google Chrome\s+([\d.]+)', result.stdout)
                if version_match:
                    return version_match.group(1)
        
        raise Exception(f"Could not determine Chrome version for platform: {platform_name}")
        
    except Exception as e:
        print(f"Error getting Chrome version: {e}")
        raise
