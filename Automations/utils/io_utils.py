def copy_file(source_file_path: str, destination_file_path: str) -> None:

    with open(source_file_path, 'rb') as source_file:
        with open(destination_file_path, 'wb') as destination_file:

            file_content = source_file.read()

            destination_file.write(file_content)

            destination_file.flush()
            destination_file.close()

        source_file.close()

