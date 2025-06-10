from Automations.utils.common_utils import get_platform


def get_driver_binary_file_extension() -> str:
    platform = get_platform()
    if platform == 'win64':
        return 'exe'
    elif platform == 'linux64':
        return ''
    elif platform == 'mac-arm64':
        return ''
    elif platform == 'mac-x64':
        return ''
    else:
        raise Exception(f'Unsupported platform: {platform}')